# FTP Upload

You can upload video files and associated metadata to your account via FTP. 
This is helpful for uploading very large files, or multiple files at once.

If desired, you can pre-configure metadata by uploading an XML file along with your video file. 
This file must contain the video source and can also be used to specify additional properties for the video, such as
* the video upload channel
* video stills
* and ownership.

* Metadata can be configured as default in the UI after the video has been uploaded. 
More information can be found in the [Important Notes](./ftpnotes.md) section.

> If you use an XML file, it must comply with [our schema](./xml.md) for the upload to succeed.

## Connecting to the FTP server

To upload your files, use the following credentials in the command line or your FTP client:

* FTP Server Host: `ftpingest.video-cdn.net`
* Username : Use your movingimage username, followed by a colon and the VideoManager Pro account ID you want to upload your video to (e.g. "example@movingimage.com:558")
* Password : Use your movingimage password

> If you do not know your account ID number, you can check your VMPro [Administration Overview](/docs/platform/vmpro/vmproadmin/accountoverview.md) page under "Account details" or contact your account manager.

> TCP keepalive
> To prevent interruptions or timeouts during file upload, ensure the TCP keepalive commands are enabled in your FTP client. On average, the command is sent in 30-second intervals.
> To learn more, search for `keepalive` or `control connection` in your FTP client's help pages.

## FTP folder structure

>The names of the files to upload do should not contain spaces or special characters, such as umlauts.

You will find the following folders on the FTP server:

* **Workspace**: Use this folder to upload video files with a corresponding XML file and still images (if desired). 
They should be uploaded in this order: *video file* → *thumbnail file* → *XML file*. This XML file triggers the upload.
* **Fast_lane**:  Use this folder to upload video files only, without XML files or thumbnails.  
* **Output**: This is where the system stores all successful uploads and files. 

After processing, files are automatically deleted from the FTP server (but not your VideoManager Pro account). 
You can prevent the system from doing this by editing your [XML file](./xml.md).

## Notifications

If you supplied an XML metadata file, it is validated against the schema immediately after file upload.
At this point, the FTP processing service will generate an result file, *<video_filename>.xml* in the output folder. 
This file indicates if the upload to the FTP server was successful, and if the XML metadata file could be validated.

> The *<video_filename>.xml* file is only a validation of the metadata. The video file itself will be further checked before transcoding; 
a success message within *<video_filename>.xml* does not guarantee that the video file itself can be transcoded.

If your video file passes further checks, and is passed for transcoding, you will receive a notification email. 
The video will then show in your VideoManager Pro account and will shortly be available for use.

You can configure additional people to be notified in the XML metadata file. 
See the [XML Schema and Sample XML File section](./xml.md) for more information.

## Error message

In case of error

If your video file does not show in your VideoManager Pro account, please contact movingimage Professional Services. 
Please include the `jobReference` and `video id` values from the *<video_filename>.xml* in the output folder:

```
<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<result fileName="myVideo.mp4" reference="MyReference" jobReference="123abc45-abcd-67ef-89ab-1234ab567890" xmlns="http://schemas.video-cdn.net/vmpro/public/v1/ingest/ftp/result.xsd">
    <success>
        <videoTitle>My Video</videoTitle>
        <video id="ABcd1234efGH5678jk90ab"/>
    </success>
</result>
```
