module.exports = {
  devServer: {
    https: false,
    port: 5000,
    open: true,
    proxy: 'http://localhost:5001/'
    },
  }