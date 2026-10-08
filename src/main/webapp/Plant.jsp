<%@ page import="java.util.List" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Home</title>

    <link href="Css/style.css" rel="stylesheet">

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css"
          rel="stylesheet">

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js"></script>

    <style>

    </style>
</head>

<body>

    <!-- logo -->
    <div class="container-fluid py-3">

        <div class="row align-items-center">

            <div class="col-md-2 text-center">

                <a href="Home.html">
                    <img src="Image/logo.png" class="logo" alt="Logo">
                </a>

            </div>

            <div class="col-md-8">

                <input type="text"
                       class="form-control search-box"
                       placeholder="Search Plants, Seeds, Pots...">

            </div>

            <div class="col-md-2 text-center">

               <a href="/ugaoo/Login.html" class="btn btn-success mt-3">
    Login
</a>

            </div>

        </div>

    </div>


    <!-- nav bar -->

    <nav class="navbar navbar-expand-lg navbar-dark bg-success">

        <div class="container">

            <button class="navbar-toggler"
                    type="button"
                    data-bs-toggle="collapse"
                    data-bs-target="#menu">

                <span class="navbar-toggler-icon"></span>

            </button>


            <div class="collapse navbar-collapse" id="menu">

                <ul class="navbar-nav mx-auto">

                    <li class="nav-item">
                        <a class="nav-link" href="Home.html">
                            HOME
                        </a>
                    </li>

                    <li class="nav-item">
                        <a class="nav-link active" href="plants">
                            PLANTS
                        </a>
                    </li>

                    <li class="nav-item">
                        <a class="nav-link" href="Seed.html">
                            SEEDS
                        </a>
                    </li>

                    <li class="nav-item">
                        <a class="nav-link" href="potandplanter.html">
                            POTS & PLANTERS
                        </a>
                    </li>

                    <li class="nav-item">
                        <a class="nav-link" href="Plantcare.html">
                            PLANT CARE
                        </a>
                    </li>

                    <li class="nav-item">
                        <a class="nav-link" href="Contact us.html">
                            CONTACT US
                        </a>
                    </li>

                </ul>

            </div>

        </div>

    </nav>


    <br>


    <!-- banner -->

    <div class="container-fluid p-0">

        <img src="Image/plant.webp"
             class="plant-banner"
             alt="Banner">

    </div>


    <br>


    <!-- plants -->

    <%
        List<String[]> products =
            (List<String[]>) request.getAttribute("products");

        int imageNumber = 1;
    %>


    <div class="row">

    <%
        if (products != null) {

            for (String[] product : products) {

                // Show only the first 12 plant products
                if (imageNumber > 12) {
                    break;
                }
    %>

        <div class="col-sm-3">

            <div class="card">

                <img class="card-img-top"
                     src="Image/p<%= imageNumber %>.png"
                     alt="<%= product[1] %>">


                <!-- Flip Part -->

                <div class="overlay">

                    <div class="text">
                        Grow more Plants
                    </div>

                </div>

                <!-- Flip Part End -->


                <div class="card-body">

                    <h4 class="card-title">
                        <%= product[1] %>
                    </h4>


                    <p class="card-text">
                        ₹<%= product[3] %>
                    </p>


                    <a href="#"
                       class="btn btn-success">

                        ADD TO CART

                    </a>

                </div>

            </div>

            <br>

        </div>


    <%
                imageNumber++;

                // Create a new row after every 4 products

                if (imageNumber == 5 ||
                    imageNumber == 9) {
    %>

    </div>

    <div class="row">

    <%
                }

            }

        } else {
    %>

        <div class="col-12 text-center">

            <h3>
                No products found.
            </h3>

        </div>

    <%
        }
    %>

    </div>


    <br>


    <!-- Footer -->

    <div class="row">

        <div class="col-md-12">

            <img src="Image/footer.png"
                 class="banner-img"
                 alt="Banner">

        </div>

    </div>


    <div class="container-fluid footer-strip">

        <div class="row">

            <div class="col foot-item">

                <img src="Image/leaf.png" alt="">

                <span>
                    Plants Grow People
                </span>

            </div>


            <div class="col foot-item">

                <img src="Image/leaf.png" alt="">

                <span>
                    Plants Grow People
                </span>

            </div>


            <div class="col foot-item">

                <img src="Image/leaf.png" alt="">

                <span>
                    Plants Grow People
                </span>

            </div>


            <div class="col foot-item">

                <img src="Image/leaf.png" alt="">

                <span>
                    Plants Grow People
                </span>

            </div>


            <div class="col foot-item">

                <img src="Image/leaf.png" alt="">

                <span>
                    Plants Grow People
                </span>

            </div>


            <div class="col foot-item">

                <img src="Image/leaf.png" alt="">

                <span>
                    Plants Grow People
                </span>

            </div>

        </div>

    </div>


    <br>


    <div class="row">

        <div class="col-sm-3 get_in_touch">

            <h4>
                About Us
            </h4>

            <a href="Plant.html">
                <p>Plants</p>
            </a>

            <a href="Seed.html">
                <p>Seeds</p>
            </a>

            <a href="potandplanter.html">
                <p>Pots & Planter</p>
            </a>

            <a href="Plantcare.html">
                <p>Plantcare</p>
            </a>

            <a href="Contact us.html">
                <p>Contact Us</p>
            </a>

        </div>


        <div class="col-sm-3">

            <h4>
                Customer Care
            </h4>

            <p>
                Shipping policy
            </p>

            <p>
                FAQs
            </p>

            <p>
                Order Related Issue
            </p>

        </div>


        <div class="col-sm-3">

            <h4>
                Offers & Rewards
            </h4>

            <p>
                Buy 2 Get 1 Free
            </p>

            <p>
                Ugaoo Cupons
            </p>

        </div>


        <div class="col-sm-3">

            <h4>
                Get In Touch
            </h4>

            <p>
                Conatct Us : +91 2345678900
            </p>

            <p>
                Email : supportugsoo@gmail.com
            </p>

            <p>
                Location : Pune Maharastra
            </p>

        </div>

    </div>


</body>

</html>