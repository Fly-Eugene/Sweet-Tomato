module.exports = {
  devServer: {
    https: false,
    port: 5001,
    open: true,
    proxy: {
      '/groupcall' : {
        target: 'https://localhost:5000/'
      },
      '/auth' : {
        target: 'https://localhost:5000/'
      },
      '/member' : {
        target: 'https://localhost:5000/'
      },
      '/profile' : {
        target: 'https://localhost:5000/'
      },
    },
    historyApiFallback: true,
    hot: true
    },
    transpileDependencies:[
      'element-plus'
    ],
    lintOnSave:false
  }


