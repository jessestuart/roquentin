/**
 * This is the Grails compile-time hook to install 3rd party JS
 * dependencies. This requires Bower (http://bower.io) to be installed.
 * This is a one-time requirement.
 * ```
 * # If npm is not installed
 * brew install npm
 * npm install -g bower
 * ```
 */
eventCompileEnd = {
    def installBowerNotification = {
        event 'StatusError', [
            "Failed to install front-end javascript dependencies. " +
                "If you're not working on the CMS, it's safe to ignore this message. "
        ]
        event 'StatusError', [
            'Please install npm and bower as described in the README. ' +
                '(i.e., brew install npm && npm install -g bower)'
        ]
    }

    try {
        event 'StatusUpdate', ['Installing node dependencies.']
        def npm = 'npm install'.execute()
        def npmReturn = npm.waitFor()
        switch (npmReturn) {
            case 0:
                event 'StatusUpdate', ['Installed NPM dependencies.']
                break
            default:
                event 'StatusError', ["Failed to install npm dependencies: ${npm.errorStream.text}"]
                break
        }

        event 'StatusUpdate', ['Installing front-end dependencies.']
        def bower = 'bower install'.execute()
        def bowerReturn = bower.waitFor()
        switch (bowerReturn) {
            case 0:
                event 'StatusFinal', ['Installed JavaScript dependencies into grails-app/assets/vendor.']
                break
            default:
                installBowerNotification()
                break
        }
    } catch (Exception e) {
        event 'StatusError', [e.getMessage()]
        installBowerNotification()
    }

}
