define(["services/service", "views/list-view"], function(service, listView) {
    var internals = {};
    var externals = {};

    externals.start = function() {
        internals.bindEventHandlers();
        service.getAPI();
        listView.render(null, service.monsterNames);
    };

    internals.bindEventHandlers = function () {
        listView.bind("buttonClick", internals.onButtonClickHandler);
    };

    internals.onButtonClickHandler = function() {
        var filmIndex = Math.floor(Math.random() * 6);
        filmService.getFilm(listView.render, filmIndex);
    };

    return externals;
});
