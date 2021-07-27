module.exports = {
  devServer: {
    https: false,
    port: 5001,
    open: true,
    proxy: 'http://localhost:5001/'
    },
  }


