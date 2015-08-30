<%@page import="java.util.List"%>
<%@page import="service.ProductAdminService.ProductManager"%>
<%@page import="model.admin.Item"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="data:image/x-icon;base64,AAABAAEAEBAAAAEAIABoBAAAFgAAACgAAAAQAAAAIAAAAAEAIAAAAAAAAAQAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA5Pbt/3zUqv8AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAGrOnv9qzp7/uunT/wAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA1vn9/5bu+v/A9fz/6/z+f7Dmzf9qzp7/as6e/2vQov/1+/V/4eK+f8jKiP/Fx4D/AAAAAAAAAAAAAAAAAAAAANP4/X9a5Pf/WuT3/13l+P/6/fx/as6e/2rOnv+S3b3/wsJ1/5GVEf+RlRH/qKtD/wAAAAAAAAAAAAAAAAAAAADs/P5/WuT3/1rk9/9a5Pf/4fr+f5fduf9qzp7//P79f52hK/+RlRH/kZUR/77Bc/8AAAAAAAAAAAAAAAAAAAAAAAAAAHvs+f9a5Pf/WuT3/6Xw+//7/vx/s+fP//n58X+RlRH/kZUR/5ebH//x8d//AAAAAAAAAAAAAAAAAAAAAFqW9v+bv/r//v//f9X6/X/H9v3/AAAAAAAAAADt7tl/ysyN//Pz5H//+e1//8xp///47f8AAAAA4u7+/yZ28/8mdvP/Jnbz/yh38/+1z/v/AAAAAAAAAAAAAAAAAAAAAP/893/+zGz//Lk2//y5Nv/8uTb//tuX/6/N+/8mdvP/Jnbz/yZ28/8mdvP/j7n5/wAAAAAAAAAAAAAAAAAAAAD/9d7//Lw8//y5Nv/8uTb//Lk2//3ASv8AAAAA9vr/fzSA9f9YmPb//P3/f/j3/n/Z0/h/AAAAAAAAAAD//v9/9977fwAAAAD/5Kj//b5A//7fov8AAAAAAAAAAAAAAAD9/P9/wbTz/3he5v9dQOH/mIXs//78/3/s0///+N35f8UC0f/IENT/2Fjl/wAAAAAAAAAAAAAAAAAAAAAAAAAA8u/9f11A4f9dQOH/XUDh/9bQ93/Lhf7/pTT9/wAAAADIENT/xQLR/8UC0f/heOf/AAAAAAAAAAAAAAAAAAAAAN3W+X9dQOH/XUDh/11A4f/+/f9/pTP8/6Uz/P/UoP7/2E7e/8UC0f/FAtH/1UXd/wAAAAAAAAAAAAAAAAAAAAC9sfP/a1Hk/4dx6f/AtvP/y4b+/6Uz/P+lM/z/pTT9//36///ZW+H/0DHa/9VI3v8AAAAAAAAAAAAAAAAAAAAA/v3/fwAAAAAAAAAAAAAAAPv1//+lM/z/pTP8/8Z//v8AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA1J7+/6c4/P8AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA/n8AAP4/AADEMwAA4gMAAOJDAADhQwAAzdkAAAPgAAADwAAAz/EAAOFHAADiQwAA4gMAAMADAAD8PwAA/n8AAA==" rel="icon" type="image/x-icon" />
        <title>Easy Buy!</title>
        <!--<link href="css/bootstrap.min.css" rel="stylesheet">-->
        <!--<link href="css/style.css" rel="stylesheet">-->
        <link href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet">
     </head>
    <body >
        <div id="wrap">
            <div class="container-">
                <div class="row-fluid">
                    <div class="col-md-12">
                        <nav class="navbar navbar-inverse" role="navigation" style="color: gold">
                            <div class="navbar-header">

                                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                                    <span class="sr-only">Toggle navigation</span><span class="icon-bar"></span><span class="icon-bar"></span><span class="icon-bar"></span>
                                </button> <a style="color: chartreuse"class="navbar-brand" href="#">EasyBuy!</a>
                            </div>

                            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                                <ul class="nav navbar-nav">
                                    <li class="active">
                                        <a href="admin.jsp">Sell in EasyBuy</a>
                                    </li>
                                    <li>
                                        <a href="#">Contact</a>
                                    </li>
                                    <li class="dropdown">
                                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">Dropdown<strong class="caret"></strong></a>
                                        <ul class="dropdown-menu">
                                            <li>
                                                <a href="#">Action</a>
                                            </li>
                                            <li>
                                                <a href="#">Another action</a>
                                            </li>
                                            <li>
                                                <a href="#">Something else here</a>
                                            </li>
                                            <li class="divider">
                                            </li>
                                            <li>
                                                <a href="#">Separated link</a>
                                            </li>
                                            <li class="divider">
                                            </li>
                                            <li>
                                                <a href="#">One more separated link</a>
                                            </li>
                                        </ul>
                                    </li>
                                </ul>

                                <ul class="nav navbar-nav navbar-right">
                                    <li>
                                        <a href="#">Login</a>
                                    </li>
                                    <li class="dropdown">
                                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">Dropdown<strong class="caret"></strong></a>
                                        <ul class="dropdown-menu">
                                            <li>
                                                <a href="#">My Orders</a>
                                            </li>
                                            <li>
                                                <a href="#">Another action</a>
                                            </li>
                                            <li>
                                                <a href="#">Something else here</a>
                                            </li>
                                            <li class="divider">
                                            </li>
                                            <li>
                                                <a href="#">Separated link</a>
                                            </li>
                                        </ul>
                                    </li>
                                </ul>
                            </div>

                        </nav>
                    </div>
                </div>
                <div class="row-fluid">	
                    <%
                        List<Item> items = ProductManager.getAllProducts();
                        for (Item myProduct : items) {
                            out.println("<div class=\"col-md-3\">");
                            out.println("<h4>" + myProduct.getProductName() + "</h4>");
                            out.println("<h1><img src=\"GetItemImage?id=" + myProduct.getProductId() + "\" width=\"120\" height =\"150\"  border=\"0\">  </h1>");
                            out.println("<p>" + myProduct.getProductDetails() + "</p>");
                            out.println("<p>" + myProduct.getPrice() + " Rs.</p>");
                            out.println("<p><a href=\"#\" class=\"btn btn-primary btn-primary\">Buy IT</a></p>");
                            out.println("<p><a href=\"GetProductDetails?productid=" + myProduct.getProductId()
                                    + "\" class=\"btn btn-success btn-primary\">Details</a></p>");
                            out.println("</div>");
                        }
                    %>


                </div>
            </div>
        </div> 

        <div class="navbar  navbar-nav" style="background-color: #333333;color: threedface ">
            <div class="container">
                <div class="row"  >
                    <div class="col-md-12">
                        <h4>
                            Sell an Item With EasyBuy
                        </h4>
                        <p>
                            List your product on our website to get more orders to your shop from the various parts of the country.Make your products  reach the customers with Ease.

                        </p>
                        <p class="addthis_horizontal_follow_toolbox"></p>
                    </div>
                  
                    <div class="col-md-12">
                        <address style="color: greenyellow">
                            <strong>EasyBuy</strong><br> TC 13/874, Vadayakaddu <br> Vanchiyoor P.O <br> <abbr title="Phone">P:</abbr> +91-8281619989
                        </address>
                    </div>
                </div>                
            </div>
        </div>                    


        <!--                    <div id="footer"  >
                                <div class="container"   >
                                    <div class="row"  >
                                        <div class="col-md-12">
                                            <h2>
                                                Sell an Item With EasyBuy
                                            </h2>
                                            <p>
                                                List your product on our website to get more orders to your shop from the various parts of the country.Make your products  reach the customers with Ease.
        
                                            </p>
                                            <p class="addthis_horizontal_follow_toolbox"></p>
                                        </div>
                                        <div class="col-md-12">
        
                                            <address>
                                                <strong>EasyBuy, Inc.</strong><br> TC 13/874, Vadayakaddu <br> Vanchiyoor P.O <br> <abbr title="Phone">P:</abbr> +91-8281619989
                                            </address>
                                        </div>
        
        
                                    </div>
                                </div>
                            </div>                  -->
        <!--        <div  class="row" style="background: #DEE1E2;">
                    <div class="col-md-8">
                        <h2>
                            Sell an Item With EasyBuy
                        </h2>
                        <p>
                            List your product on our website to get more orders to your shop from the various parts of the country.Make your products  reach the customers with Ease.
        
                        </p>
                        <p class="addthis_horizontal_follow_toolbox"></p>
        
                    </div>
                    <div class="col-md-4">
        
                        <address>
                            <strong>EasyBuy, Inc.</strong><br> TC 13/874, Vadayakaddu <br> Vanchiyoor P.O <br> <abbr title="Phone">P:</abbr> +91-8281619989
                        </address>
                    </div>
                </div>-->

        <!-- Go to www.addthis.com/dashboard to customize your tools -->

        <!-- Go to www.addthis.com/dashboard to customize your tools -->
        <script type="text/javascript" src="//s7.addthis.com/js/300/addthis_widget.js#pubid=ra-55df0267066c5ea4" async="async"></script>

        <!--    <script src="js/jquery.min.js"></script>
            <script src="js/bootstrap.min.js"></script>
            <script src="js/scripts.js"></script>-->

        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
        <!-- Include all compiled plugins (below), or include individual files as needed -->
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
    </body>
</html>