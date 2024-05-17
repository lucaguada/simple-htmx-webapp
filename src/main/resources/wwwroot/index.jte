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

  <link rel="preload" href="./font/ProximaNova-Reg-webfont.woff2" as="font" type="font/woff2" crossorigin/>
  <link rel="preload" href="./font/ProximaNova-Light-webfont.woff2" as="font" type="font/woff2" crossorigin/>

  <script src="https://cdn.tailwindcss.com"></script>
  <link href="https://cdn.jsdelivr.net/npm/daisyui@4.11.1/dist/full.min.css" rel="stylesheet" type="text/css" />
  <title>Webapp</title>
  <style>
    html, body { height: 100%; }
  </style>
</head>
<body style="background-image: url(./img/blob-scene-haikei.svg); background-size: cover">
  @template.component.blogGrid()
</body>
</html>
