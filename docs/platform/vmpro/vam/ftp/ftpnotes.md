# FTP Notes

The following information applies to file upload via FTP to the movingimage server.

## Uploading without an XML file

If a video file is uploaded without an XML file, the system will use the original file name as the title. All other metadata will be blank.

## Uploading with an XML file

To import metadata for a video, an XML file formatted according to the validation schema must be uploaded after the video file.
The XML file should always be uploaded last. This is because the XML file triggers the uploading process.
If a tag is defined in the XML file, it must not be left blank or an error will occur and the video will not upload.

## Thumbnails

Uploads should be done in this order: video file → thumbnail file → XML file.
Thumbnails must not be larger than 10000 KB. 
If a thumbnail image is not provided after defining one in the XML file, an error will occur and the video will not upload.

## Subtitles

Uploads should be done in this order: video file → subtitle file(s) → XML file.
Subtitle files must in the .srt or .vtt formats.

## Character Encoding

If you need to use reserved XML characters within your metadata file, they must be encoded. 
There are two different encoding options:
```
<keyword>&lt;h1&gt;foo bar&lt;/h1&gt;</keyword> 
```
```
<keyword><![CDATA[<h1>foo bar </h1>]]></keyword>
```