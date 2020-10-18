<#--in base.ftl:-->
<#macro main css=[]>
    <!DOCTYPE html>
    <html lang="ru">
<head>
    <meta charset="UTF-8">
    <title>Home</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <#--    <style>-->
    <#--        <#include "SpaceDrive/css/style.css">-->
    <#--    </style>-->
    <link rel="stylesheet" href="/SpaceDrive/css/home_page.css">
    <link rel="stylesheet" href="/SpaceDrive/css/confirmation.css">
    <link rel="stylesheet" href="/SpaceDrive/css/feed.css">
    <link rel="stylesheet" href="/SpaceDrive/css/news.css">
    <link rel="stylesheet" href="/SpaceDrive/css/profile.css">
    <link rel="stylesheet" href="/SpaceDrive/css/ticket_page.css">
    <link rel="stylesheet" href="/SpaceDrive/css/login.css">
    <link rel="stylesheet" href="/SpaceDrive/css/profile_edit.css">
    <link rel="stylesheet" href="/SpaceDrive/css/profile.css">
    <link rel="stylesheet" href="/SpaceDrive/css/pilots.css">
</head>
<body>
<div class="wrapper">

    <#include "Header.ftl">

    <#nested>

</div>
</body>
</#macro>