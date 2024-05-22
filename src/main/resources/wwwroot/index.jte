@import org.acme.webapp.Webapp.Model

@param Model model
<!DOCTYPE html>
<!--suppress HtmlUnknownAttribute -->
<html lang="en" data-theme="cupcake">
<head>
  <meta charset="UTF-8">

  <link rel="apple-touch-icon" sizes="180x180" href="./manifest/apple-touch-icon.png">
  <link rel="icon" type="image/png" sizes="32x32" href="./manifest/favicon-32x32.png">
  <link rel="icon" type="image/png" sizes="16x16" href="./manifest/favicon-16x16.png">
  <link rel="manifest" href="./manifest/site.webmanifest">
  <link rel="mask-icon" href="./manifest/safari-pinned-tab.svg" color="#5bbad5">
  <meta name="msapplication-TileColor" content="#da532c">

  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">

  <link href="https://fonts.googleapis.com/css?family=Nunito:400,700&display=swap" rel="stylesheet">
  <link href="./css/uikit.min.css" rel="stylesheet">
  <script src="./js/uikit.min.js" type="application/javascript"></script>
  <script src="./js/uikit-icons.min.js" type="application/javascript"></script>
  <title>Webapp</title>
  <style>
    html, body, h1, h2, h3, h4, h5, h6, #anacleto.uk-navbar-item {
      color: rgba(55, 65, 81, 1);
      font-family: 'Nunito', 'Arial', sans-serif;
      letter-spacing: -.025em;
      line-height: 2;
      background-color: rgba(243, 244, 246, 1);
    }
  </style>
</head>
<body>
  <nav class="uk-navbar-container uk-navbar-transparent">
    <div class="uk-container uk-container-expand">
      <div uk-navbar>
        <div class="uk-navbar-left">
          <span id="anacleto" class="uk-navbar-item" style="font-weight: bold; font-size: 1rem">Anacleto's Blog</span>
          <a class="uk-navbar-item uk-link-reset" href="#" uk-tooltip="title: Tech Blog; pos: bottom">🧑‍💻</a>
          <a class="uk-navbar-item uk-link-reset" href="#" uk-tooltip="title: Mythology Blog; pos: bottom">🏛</a>
          <a class="uk-navbar-item uk-link-reset" href="#" uk-tooltip="title: Switch Theme; pos: bottom">🌙</a>
        </div>
      </div>
    </div>
  </nav>
  <section class="uk-container uk-container-expand">
    <div class="uk-flex uk-grid-large" uk-grid>
      <div class="uk-width-2-5@m uk-flex-first@m uk-text-right">
        <p class="uk-heading-line"><span style="font-weight: bold">Previous Posts</span></p>
        <ul class="uk-list">
          <li><a class="uk-link-reset" href="">Is functional programming a pure theoretic paradigm?</a></li>
          <li><a class="uk-link-reset" href="">How to develop a plain HTTP server in Java</a></li>
          <li><a class="uk-link-reset" href="">How to implement CQRS properly</a></li>
          <li><a class="uk-link-reset" href="">What is Event Sourcing and why does it matter?</a></li>
        </ul>
      </div>
      <div class="uk-width-3-5@m uk-flex-first@s uk-text-left">
        <p class="uk-heading-line"><span style="font-weight: bold">How to design the Mammal object nowadays</span></p>
      </div>
      <div class="uk-width-2-5@m uk-flex-last@m uk-flex-last@s" uk-sticky="position: bottom">
        <div class="uk-card uk-card-default uk-card-body uk-margin-small-bottom">A Riguardo</div>
      </div>
    </div>
  </section>
</body>
<script src="./js/darktheme.js"></script>
</html>
