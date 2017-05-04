        $(function() {
        
        $('#slideshow ul').cycle({
           fx : 'fade',
           speed: 2000,
           timeout: 5000
           
        }).fadeIn(0);
 
        $('.thumb').hover(function(){
           $(this).find('.sinopse').fadeIn(500);
           $(this).find('img').addClass('transition').css({
                '-webkit-filter' : 'blur(1px)',
                '-moz-filter': 'blur(1px)',
                '-o-filter': 'blur(1px)',
                '-ms-filter': 'blur(1px)',
                'filter': 'blur(1px)'
           });
        },
        function(){
            $(this).find('.sinopse').fadeOut();
            $(this).find('img').css({
                '-webkit-filter' : 'blur(0)',
                '-moz-filter': 'blur(0x)',
                '-o-filter': 'blur(0)',
                '-ms-filter': 'blur(0)',
                'filter': 'blur(0)'
           });
        });

        $('.menu-anchor').click(function(){
           $('#searching').hide(); 
           $('.main_nav-active').fadeIn(1000);

        });
        
        $('.closepopup').hide().delay(1500).fadeIn(1000).click(function(){
        $('#popup').slideUp(800);
        $('#darkness').fadeOut(800);
        });


        $('.searc').click(function(){
           $('#searching').fadeIn(2000); 
           $('.main_nav-active').hide();
        });
        
       });