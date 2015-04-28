###
  Grunt is a 'JavaScript Task Runner'.

  We use it as part of our *development and test cycle* to execute
  our javascript unit tests through Karma. To execute tests once,
  run `grunt karma:unit`. To execute tests continuously, run
  `grunt karma:continous` and tests will update as files are changed.
###
module.exports = (grunt) ->
  grunt.initConfig
    karma:
      unit:
        configFile: 'test/javascript/config/karma.conf.js'
        reporters: ['progress']
      continuous:
        configFile: 'test/javascript/config/karma.conf.js'
        reporters: ['progress']
        singleRun: false

  grunt.loadNpmTasks 'grunt-karma'
