define(function() {
    var internals = {};
    var externals = {};

    externals.monsterNames = [];

    externals.getAPI = function () {

        $.ajax({
            url: "https://www.dnd5eapi.co/api/monsters/",
            type: "GET",
            dataType: "json",
            success: internals.getMonsterNames
        });
    };

    internals.getMonsterNames = function (api) {

        api.results.forEach(function(monster) {
            externals.monsterNames.push(monster.name);
        });
    }

    return externals;
});
