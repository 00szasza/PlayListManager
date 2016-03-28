/**
 * Created by szasza on 2016. 02. 13..
 */
(function (){
    var console = window.console;

    if( !console.log ){
        console.log = function (){
            alert([].join.apply(arguments, ' '));
        };
    }


    new Sortable(foo, {
        group: "words",
        store: {
            get: function (sortable) {
                var order = localStorage.getItem(sortable.options.group);
                return order ? order.split('|') : [];
            },
            set: function (sortable) {
                var order = sortable.toArray();
                localStorage.setItem(sortable.options.group, order.join('|'));
            }
        },
        onAdd: function (evt){ console.log('onAdd.foo:', evt.item); },
        onUpdate: function (evt){ console.log('onUpdate.foo:', evt.item); },
        onRemove: function (evt){ console.log('onRemove.foo:', evt.item); },
        onStart:function(evt){ console.log('onStart.foo:',evt.item);},
        onEnd: function(evt){
            console.log('onEnd.foo:', evt.item.id);
            console.log('onEnd.foo:index:', $(evt.item).index());
            setplaylist(evt);
        }
    });


    new Sortable(bar, {
        group: "words",
        onAdd: function (evt){ console.log('onAdd.bar:', evt.item); },
        onUpdate: function (evt){ console.log('onUpdate.bar:', evt.item); },
        onRemove: function (evt){ console.log('onRemove.bar:', evt.item); },
        onStart:function(evt){ console.log('onStart.foo:', evt.item);},
        onEnd: function(evt){
            console.log('onEnd.foo:', evt.item);
            setplaylist(evt);
        }
    });

    new Sortable(temp, {
        group: "words",
        onAdd: function (evt){ console.log('onAdd.bar:', evt.item); },
        onUpdate: function (evt){ console.log('onUpdate.bar:', evt.item); },
        onRemove: function (evt){ console.log('onRemove.bar:', evt.item); },
        onStart:function(evt){ console.log('onStart.foo:', evt.item);},
        onEnd: function(evt){
            console.log('onEnd.foo:', $(evt.item).index());
            //setplaylist(evt);
            $.ajax({
                type : "POST",
                data : "item=" + $(evt.item).text(),
                url : "del",
                success : function(response) {
                    console.log(response);
                    $(evt.item).delay(1000).fadeOut('slow');
                }
            });
        }
    });


    function setplaylist(evt)
    {



        var items = [];
        $("#foo li").each(function()
        {
            items.push($(this).text());
        });
        console.log('onEnd.foo:all:', items);

        $.ajax({
            type : "POST",
            data : "items=" + items,
            url : "setplaylist",
            success : function(response) {
                console.log(response);
            }
        });

    };


})();

