/**
 * Created by jojoldu@zuminternet.com on 2016-06-30.
 */
var path = require('path');

module.exports = {
    entry: './app.js',
    devtool: 'sorcemaps',
    cache: true,
    debug: true,
    output:{
        path: __dirname,
        filename: './'
    }
};