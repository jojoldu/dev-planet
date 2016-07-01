/**
 * Created by jojoldu@gmail.com on 2016-06-30.
 */
module.exports = {
    // 가장 처음 읽을 스크립트파일
    // 여기서부터 import 되어있는 다른 스크립트를 불러온다.
    entry: './app.js',

    // 파일을 합치고 ./public/bundle.js 에 저장한다.
    output: {
        path: __dirname+'/src/main/resources/static/webpack',
        filename: 'bundle.js'
    },

    module: {
        loaders: [
            {
                test: /\.js$/,
                loader: 'babel',
                exclude: /node_modules/,
                query: {
                    cacheDirectory: true,
                    presets: ['es2015', 'react']
                }
            }
        ]
    }
};