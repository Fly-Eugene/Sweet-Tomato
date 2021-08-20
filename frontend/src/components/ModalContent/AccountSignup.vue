<template>
  <section class="signup_body">
    <div class="circle"></div>
    <div class="rectangle"></div>
    <section class="signup_card">
      <article class="signup_left">
        <div class="toMain">
          <router-link :to="{ name: 'AccountLogin' }">
            <svg
              xmlns="http://www.w3.org/2000/svg"
              height="24px"
              viewBox="0 0 24 24"
              width="24px"
              fill="#000000"
            >
              <path d="M0 0h24v24H0V0z" fill="none" />
              <path
                d="M20 11H7.83l5.59-5.59L12 4l-8 8 8 8 1.41-1.41L7.83 13H20v-2z"
              />
            </svg>
            이전
          </router-link>
        </div>
        <div class="signup_left_content">
          <h2>Sweet Tomato</h2>
          <form enctype="multipart/form-data">
            <div class="profile_box">
              <img
                v-if="state.profile_image === ''"
                class="profile"
                src="@/assets/img/basic_profile.png"
              />
              <div
                v-else
                class="profile"
                :style="`background-image : url(${state.profile_image})`"
              ></div>
            </div>
            <div class="filebox">
              <label for="file">프로필 변경</label>
              <input
                @change="upload"
                accept="image/*"
                type="file"
                id="file"
                name="profile"
              />
            </div>
          </form>
        </div>
      </article>
      <article class="signup_right">
        <div class="signup_right_content">
          <h2>회원가입</h2>
          <span>회원가입을 위해 아래의 정보를 입력해주세요</span>
          <form class="signup_form" ref="signupForm" @submit="onSignupSubmit">
            <div>
              <input
                type="email"
                v-model="email"
                name="email"
                placeholder="이메일"
              />
              <p>{{ emailError }}</p>
            </div>
            <div>
              <input
                type="text"
                v-model="username"
                name="username"
                placeholder="닉네임"
              />
              <p>{{ usernameError }}</p>
            </div>
            <div>
              <input
                type="password"
                v-model="password"
                name="password"
                placeholder="비밀번호"
              />
              <p>{{ passwordError }}</p>
            </div>
            <div>
              <input
                type="password"
                v-model="passwordConfirmation"
                name="passwordConfirmation"
                placeholder="비밀번호 확인"
              />
              <p>{{ passwordConfirmationError }}</p>
            </div>
            <div>
              <input
                type="number"
                v-model="age"
                name="age"
                placeholder="나이"
              />
              <p>{{ ageError }}</p>
            </div>
            <div>
              <input
                type="text"
                v-model="group"
                name="group"
                placeholder="조직"
              />
              <p>{{ groupError }}</p>
            </div>
            <footer>
              <label
                ><input
                  type="checkbox"
                  class="checkword"
                  name="agreement"
                  value="agree"
                />이 사이트의 이용방침에 동의합니다</label
              >
            </footer>
            <button class="signupBtn">회원 가입</button>
          </form>
        </div>
      </article>
    </section>
  </section>
</template>

<script>
import "@/assets/style/signup.scss";
import * as yup from "yup";
import { useForm, useField } from "vee-validate";
import { computed, reactive } from "@vue/runtime-core";
import { useStore } from "vuex";
import $axios from "axios";
import { useRouter } from "vue-router";

export default {
  name: "AccountSignup",

  setup() {
    const store = useStore();
    const router = useRouter();
    const state = reactive({
      selectedFile: null,
      profile_image: "",
    });
    const schema = computed(() => {
      return yup.object({
        email: yup.string().email().required(),
        password: yup
          .string()
          .required("Please enter your password")
          .matches(
            /^.*(?=.{8,16})((?=.*[!@#$%^&*()\-_=+{};:,<.>]){1})(?=.*\d)((?=.*[a-z]){1})((?=.*[A-Z]){1}).*$/,
            "Password must contain at least 8 characters, one uppercase, one number and one special case character"
          ),
        passwordConfirmation: yup
          .string()
          .required("Please confirm your password")
          .oneOf([yup.ref("password"), null], "Passwords don't match."),
        username: yup.string().required().min(4),
        age: yup.number(),
        group: yup.string(),
      });
    });

    const { handleSubmit } = useForm({ validationSchema: schema });

    const { value: email, errorMessage: emailError } = useField("email");
    const { value: password, errorMessage: passwordError } =
      useField("password");
    const {
      value: passwordConfirmation,
      errorMessage: passwordConfirmationError,
    } = useField("passwordConfirmation");
    const { value: username, errorMessage: usernameError } =
      useField("username");
    const { value: age, errorMessage: ageError } = useField("age");
    const { value: group, errorMessage: groupError } = useField("group");

    const onSignupSubmit = handleSubmit(() => {
      var frm = new FormData();
      var photoFile = document.getElementById("file");
      if (photoFile.files[0]) {
        frm.append("files", photoFile.files[0]);
      }
      frm.append(
        "jsonData",
        JSON.stringify({
          email: email._value,
          password: password._value,
          username: username._value,
          age: age._value,
          department: group._value,
        })
      );
      $axios
        .post("https://i5b106.p.ssafy.io:5000/member/join", frm, {
          headers: {
            "Content-Type": "multipart/form-data",
          },
        })
        .then(function () {
          router.push({ name: "AccountLogin" });
        })
        .catch(function (err) {
          alert(err);
        });
    });

    function upload(e) {
      var file = e.target.files;
      state.selectedFile = file[0];
      console.log(file[0]);
      let url = URL.createObjectURL(file[0]);
      console.log(url);
      state.profile_image = url;
    }

    return {
      store,
      state,

      email,
      emailError,
      password,
      passwordError,
      passwordConfirmation,
      passwordConfirmationError,
      username,
      usernameError,
      age,
      ageError,
      group,
      groupError,

      onSignupSubmit,
      upload,
    };
  },
};
</script>

<style>
</style>