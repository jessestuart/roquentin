/**
 * Karma runs our front-end unit tests.
 * This configuration file sets all this up.
 */
module.exports = function(config) {
  config.set({
    // base path that will be used to resolve all patterns (eg. files, exclude)
    basePath: '../../../',

    // frameworks to use
    // available frameworks: https://npmjs.org/browse/keyword/karma-adapter
    frameworks: ['jasmine'],
    plugins: [
        'karma-jasmine',
        'karma-phantomjs-launcher',
        'karma-coffee-preprocessor',
        'karma-remote-reporter'
    ],

    // list of files / patterns to load in the browser
    files: [
        // Vendor
        'grails-app/assets/vendor/angular/angular.js',
        'grails-app/assets/vendor/angular-animate/angular-animate.js',
        'grails-app/assets/vendor/angular-route/angular-route.js',
        'grails-app/assets/vendor/angular-mocks/angular-mocks.js',
        'grails-app/assets/vendor/angular-bootstrap/ui-bootstrap.js',
        'grails-app/assets/vendor/angular-bootstrap/ui-bootstrap-tpls.js',
        'grails-app/assets/vendor/underscore/underscore.js',
        'grails-app/assets/vendor/karma-read-json/karma-read-json.js',

        // App
        'grails-app/assets/javascripts/apps/**/*.coffee',
        'grails-app/assets/javascripts/application.js',

        // Test specs
        'test/javascript/unit/*.coffee',

        // Fixtures
        {pattern: 'test/data/*.json', watched: true, served: true, included: false}
    ],

    // list of files to exclude
    exclude: [],

    // preprocess matching files before serving them to the browser
    preprocessors: {
        '**/*.coffee': ['coffee']
    },

    // test results reporter to use
    // possible values: 'dots', 'progress'
    // available reporters: https://npmjs.org/browse/keyword/karma-reporter
    reporters: ['progress', 'remote'],
    remoteReporter: {
        host: 'localhost',
        port: '9889'
    },

    // web server port
    port: 9876,

    // enable / disable colors in the output (reporters and logs)
    colors: true,

    // level of logging
    // possible values: config.LOG_DISABLE || config.LOG_ERROR || config.LOG_WARN || config.LOG_INFO || config.LOG_DEBUG
    logLevel: config.LOG_INFO,

    // enable / disable watching file and executing tests whenever any file changes
    autoWatch: true,

    // start these browsers
    // available browser launchers: https://npmjs.org/browse/keyword/karma-launcher
    browsers: ['PhantomJS'],

    // Continuous Integration mode
    // if true, Karma captures browsers, runs the tests and exits
    singleRun: true
  });
};
