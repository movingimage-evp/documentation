# Subtitle Upload

You have the option to upload one or more subtitle files as part of the main FTP upload process. This saves time over uploading individual subtitle files manually through the VideoManager Pro web interface.

In order to upload subtitles, your VideoManager Pro account must be enabled for subtitles, and the user account that you upload with must belong to a role with the subtitle management permission.

## Subtitle file types

As with uploading through the VideoManager Pro web interface, subtitle files in the .srt and .vtt formats are accepted.

## Additional properties in the XML file

To include subtitles, you must follow the format shown in this sample XML file.

> If you do not include the related subtitle file(s), the upload will fail. You must upload your files in this order: video file → subtitle file(s) → XML file.
> Uploading multiple subtitle files with the same locale value is not supported. The video will be uploaded without subtitles.

<details>

```
<?xml version="1.0" encoding="UTF-8" ?>
<job xmlns="http://schemas.video-cdn.net/vmpro/public/v1/ingest/ftp/job.xsd" reference="mySubtitleVideo">
  <source>
    <file>video001.mp4</file>
  </source>
  <title>My Video With Subtitles</title>
  <subtitles>
    <subtitle>
      <file>subtitle_en.srt</file>
      <locale>en</locale>
    </subtitle>
    <subtitle>
      <file>subtitle_de.vtt</file>
      <locale>de</locale>
    </subtitle>
  </subtitles>
</job>
```

</details>

## Locale information

Each subtitle property tag must include both the file and locale tags. Supported locale values are:

| ar    | bg    | en-IE | es-NI | ga-IE | lt-LT | pt-BR | sv-SE |
| ----- | ----- | ----- | ----- | ----- | ----- | ----- | ----- |
| ar-AE | bg-BG | en-IN | es-PA | he    | lv    | pt-PT | th    |
| ar-BH | ca    | en-MT | es-PE | he-IL | lv-LV | ro    | th-TH |
| ar-DZ | ca-ES | en-NZ | es-PR | hi-IN | mk    | ro-RO | tr    |
| ar-EG | cs    | en-PH | es-PY | hr    | mk-MK | ru    | tr-TR |
| ar-IQ | cs-CZ | en-SG | es-SV | hr-HR | ms    | ru-RU | uk    |
| ar-JO | da    | en-US | es-US | hu    | ms-MY | se    | uk-UA |
| ar-KW | da-DK | en-ZA | es-UY | hu-HU | mt    | se-NO | vi    |
| ar-LB | de    | es    | es-VE | id    | mt-MT | sk    | vi-VN |
| ar-LY | de-AT | es-AR | et    | id-ID | nb    | sk-SK | zh    |
| ar-MA | de-CH | es-BO | et-EE | is    | nb-NO | sl    | zh-CN |
| ar-OM | de-DE | es-CL | fi    | is-IS | nl    | sl-SI | zh-HK |
| ar-QA | de-LU | es-CO | fi-FI | it    | nl-BE | sq    | zh-SG |
| ar-SA | el    | es-CR | fr    | it-CH | nl-NL | sq-AL | zh-TW |
| ar-SD | el-CY | es-DO | fr-BE | it-IT | nn-NO | sr    |       |
| ar-SY | el-GR | es-EC | fr-CA | ja    | no    | sr-BA |       |
| ar-TN | en    | es-ES | fr-CH | ja-JP | no-NO | sr-CS |       |
| ar-YE | en-AU | es-GT | fr-FR | ko    | pl    | sr-ME |       |
| be    | en-CA | es-HN | fr-LU | ko-KR | pl-PL | sr-RS |       |
| be-BY | en-GB | es-MX | ga    | lt    | pt    | sv    |       |