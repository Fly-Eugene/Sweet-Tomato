<template>
  <header class="select_open">
    <div
      v-if="state.study_security === 'public'"
      class="select_open_btn_public"
      @click="onClickSecurity"
    >
      <i class="fas fa-lock-open fa-2x"></i>
    </div>
    <div v-else class="select_open_btn_private" @click="onClickSecurity">
      <i class="fas fa-lock fa-2x"></i>
    </div>
  </header>
  <section class="make_study_content">
    <article class="card_left">
      <div v-if="state.profile_image === ''" class="background_photo"></div>
      <div
        v-else
        class="background_photo"
        :style="`background-image : url(${state.profile_image})`"
      ></div>
      <label for="file" class="background_photo_btn">
        <p>스터디 프로필</p>
      </label>
      <input
        @change="upload"
        accept="image/*"
        type="file"
        id="file"
        name="study_profile"
      />
    </article>
    <article class="card_right">
      <div class="study_name">
        <span>스터디 이름</span>
        <input type="text" v-model="study_name" />
      </div>
      <div class="hash_tag">
        <span>해시태그</span>
        <input
          type="text"
          placeholder="#어떤 종류의 스터디 인가요? 🔍"
          v-model="hash_tag"
          @keyup.enter="onEnter"
        />
      </div>
      <div class="hash_tag_content">
        <div class="hash_tag_item" v-for="hash in hash_tag_list" :key="hash">
          {{ hash }}
        </div>
      </div>
      <div class="study_content">
        <span>스터디 소개 🙌🏻</span>
        <br />
        <textarea
          cols="30"
          rows="10"
          type="text"
          placeholder="스터디를 멋지게 표현해주세요 👏🏻"
          v-model="study_content"
        ></textarea>
      </div>
    </article>
    <button class="make_study_btn" @click="onClickMakeStudy">
      <p>스터디 만들기</p>
    </button>
  </section>
</template>

<script>
import "@/assets/style/Modal/make_study.scss";
import { reactive, ref } from "vue";
// import { useStore } from 'vuex'
import $axios from "axios";

export default {
  // name: "MakeStudy",
  components: {},

  setup() {
    // const store = useStore()
    const state = reactive({
      selectedFile: null,
      profile_image: "",
      study_security: "public",
    });

    const study_name = ref("");
    const hash_tag = ref("");
    const hash_tag_list = ref([]);
    const study_content = ref("");

    function upload(e) {
      const file = e.target.files;
      state.selectedFile = file[0];
      console.log(file[0]);
      const url = URL.createObjectURL(file[0]);
      console.log(url);
      state.profile_image = url;
    }

    const onEnter = function () {
      hash_tag_list.value.push("#" + hash_tag.value);
      hash_tag.value = "";
    };

    const onClickMakeStudy = function () {
      const frm = new FormData();
      const photoFile = document.getElementById("file");
      if (photoFile.files[0]) {
        frm.append("files", photoFile.files[0]);
      }
      frm.append(
        "jsonData",
        JSON.stringify({
          studyName: study_name.value,
          studyIntro: study_content.value,
          secutiry: state.study_security,
          themes: hash_tag_list.value,
        })
      );
      $axios
        .post("https://i5b106.p.ssafy.io:5000/study", frm, {
          headers: {
            "Content-Type": "multipart/form-data",
          },
        })
        .then((res) => {
          console.log(res);
        })
        .catch((err) => {
          console.log(err);
        });
    };

    const onClickSecurity = function () {
      console.log("함수 실행 중");
      if (state.study_security === "public") {
        state.study_security = "private";
      } else {
        state.study_security = "public";
      }
    };

    return {
      state,
      study_name,
      hash_tag,
      hash_tag_list,
      study_content,

      upload,
      onEnter,
      onClickMakeStudy,
      onClickSecurity,
    };
  },
};
</script>

<style>
</style>            