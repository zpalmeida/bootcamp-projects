define(function() {

    var internals = {};
    var externals = {};

    internals.routes = {
        list: {
            hash: "#list",
            controller: "list-controller",
        },
        element: {
            hash: "#element",
            controller: "element-controller",
        },
    };

    internals.defaultRoute = "list";
    internals.currentHash = "";

    internals.hashCheck = function() {

        if(window.location.hash === internals.currentHash) {
            return;
        }
        var routeName = Object.keys(internals.routes).find(function(name) {
            return window.location.hash === internals.routes[name].hash;
        });

        if (!routeName) {
            internals.loadDefaultRoute();
            return;
        }
        internals.loadController(internals.routes[routeName].controller);
    };

    internals.loadController = function(controllerName) {
        internals.currentHash = window.location.hash;

        require(["controllers/" + controllerName], function(controller) {

            try{
                controller.start();

            } catch(error) {
                console.log(error.stack);

                window.location.hash =
                    internals.routes[internals.defaultRoute].hash;
            }
        });
    };

    internals.loadDefaultRoute = function() {
        window.location.hash = internals.routes[internals.defaultRoute].hash;
        internals.loadController(internals.routes[internals.defaultRoute].controller);
    };

    externals.start = function() {

        window.location.hash = window.location.hash ||
        internals.routes[internals.defaultRoute].hash;

        setInterval(internals.hashCheck, 150);
    };

    return externals;
});
