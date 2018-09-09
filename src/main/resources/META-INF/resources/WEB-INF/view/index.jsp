<%@ include file="header.jspf" %>

<script
        src="https://code.jquery.com/jquery-3.3.1.min.js"
        integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
        crossorigin="anonymous"></script>

<script type="application/javascript">

    $('custom-form').on('submit', function (e) {
        for (var i = 0; i < 1000000; ++i) {
            var b = i / 2;
        }
    });

</script>

<!-- Header -->
<div class="text-white text-center">
    <div class="container">
        <img class="img-fluid mb-5 d-block mx-auto" src="../img/profile.png" alt="" width="250" height="250">
        <h1 class="text-uppercase mb-0">Instagram randomizer</h1>
        <hr class="star-light">

    </div>

    <div class="container">
        <form target="_blank" method="post" action="/random" id="custom-form">
            <div class="input-group">
                <input type="text" class="form-control" placeholder="Type instagram url...">
                <span class="input-group-btn">
                    <button id="submit" class="btn btn-success" type="submit" value="Choose the winner">Choose the winner</button>
                </span>
            </div>
        </form>
    </div>
</div>

<%@ include file="footer.jspf" %>

