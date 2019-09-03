<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.inputmask/3.3.4/inputmask/inputmask.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.inputmask/3.3.4/inputmask/jquery.inputmask.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>

<script>
    $("#phone").inputmask({"mask":"+7 (999) 999-9999"});
</script>
        <script>
            $("#login").change(function(){
                $.ajax({
                    url: "flowershop/rest/check_login/"+$("#login").val(),
                    success: function(data) {
                        if (data == "false"){
                            $("#submit").removeAttr("disabled");
                            $("#login").removeClass("is-invalid");
                        }
                        else{
                            $("#submit").attr("disabled", "true");
                            $("#login").addClass("is-invalid");
                        }
                    }
                });
            });
        </script>
    </body>
</html>