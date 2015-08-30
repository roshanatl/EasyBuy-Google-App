<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Member Login</title>

        <!-- Bootstrap -->
        <link href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet">

        <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
          <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
          <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
        <![endif]-->
    </head>
    <body>
        <h1> Add a Item to List in EasyBuy!!</h1>
        <form action="AddProduct" method="post" enctype="multipart/form-data">
            <p>Item name : <input type="text" name="itemname"> </p>
            <p>Item details : <input type="text" name="itemdetails"></p>
            <p>Item image : <input type="file" name="itempic" </p>
            <p>Item price : <input type=text name="itemprice"></p>
            <p>Item quantity : <input type=text name="itemquantity"></p>
            <p><input type="submit" value="Add Item" ></p>
        </form>
    </body>
</html>
