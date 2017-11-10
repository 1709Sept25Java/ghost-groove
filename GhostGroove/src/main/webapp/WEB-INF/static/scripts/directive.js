(function(){
    app.directive("directive",function(){
        return{
            templateUrl:"../GhostGroove/views/directive.html",
            link:function(scope,elem,attrs){
                console.log("Scope: "+ scope);
            }
        }
    });
})();