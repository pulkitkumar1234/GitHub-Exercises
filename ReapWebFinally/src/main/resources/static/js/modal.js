$(document).ready(function(){
    $('.table .dbtn').on('click',function(event){

        event.preventDefault();
        var href=$(this).attributes('href');
        
        $.get(href,function (fame,status) {
            $('.deletewalloffameform #id').value(fame.id);
            $('.deletewalloffameform #giverid').value(fame.id);
            $('.deletewalloffameform #givername').value(fame.id);
            $('.deletewalloffameform #receiversid').value(fame.id);
            $('.deletewalloffameform #receivernames').value(fame.id);
            $('.deletewalloffameform #reason').value(fame.id);
            $('.deletewalloffameform #karmas').value(fame.id);
            $('.deletewalloffameform #badgetype').value(fame.id);
            $('.deletewalloffameform #givenDateAndTime').value(fame.id);
        })
        $('.deletewalloffameform #deletewalloffamemodal').modal();
    });
});