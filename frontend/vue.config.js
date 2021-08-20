module.exports = {
  devServer: {
    https: true,
    port: 5001,
    open: true,
    proxy: {
      '/groupcall' : {
        target: 'https://i5b106.p.ssafy.io:5000/'
      },
      '/auth' : {
        target: 'https://i5b106.p.ssafy.io:5000/'
      },
      '/member' : {
        target: 'https://i5b106.p.ssafy.io:5000/'
      },
      '/profile' : {
        target: 'https://i5b106.p.ssafy.io:5000/'
      },
    },
    historyApiFallback: true,
    hot: true
    },
    transpileDependencies:[
      'element-plus'
    ],
    lintOnSave:false,
    outputDir: '../backend/src/main/resources/static'
  }


