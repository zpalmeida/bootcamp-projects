define(function() {
    var internals = {}
    var externals = {};

    internals.elements = {};
    internals.handlers = {};

    externals.render = function (film, array) {
        internals.elements.app = $("#app");
        internals.renderButtonList(array);

        if (film) {
            internals.renderFilm(film);
        }
    };

    externals.bind = function (eventName, handler) {
        internals.handlers[eventName] = handler;
    };

    internals.renderButtonList = function(array) {

        console.log("here");

        for (var i = 0; i < array.length; i++) {
            console.log(array[i]);
        }

        array.forEach(function(string) {

            internals.elements.button = $(internals.createButton(string));
            internals.elements.button.click(internals.handlers["buttonClick"]);
            internals.elements.app.append(internals.elements.button);
        });
    };
/*
    internals.renderButton = function() {
        if (internals.elements.button) {
            return;
        }

        internals.elements.button = $(internals.createButton("Aboleth"));
        internals.elements.button.click(internals.handlers["buttonClick"]);
        internals.elements.app.append(internals.elements.button);
    };*/

    internals.renderFilm = function(film) {
        if (internals.elements.filmCard) {
            internals.elements.filmCard.empty();
        }

        internals.elements.filmCard = $(internals.createFilmCard(film));
        internals.elements.app.append(internals.elements.filmCard);
    };

    internals.createFilmCard = function(film) {

        return "<div>" +
            "<p><strong>Title: </strong>" +
            film.title +
            "</p>" +
            "<p><strong>Year: </strong>" +
            film.year +
            "</p>" +
            "</div>";
    };

    internals.createButton = function(monsterName) {
        return "<button>" + monsterName + "</button>";
    };

    return externals;
});
