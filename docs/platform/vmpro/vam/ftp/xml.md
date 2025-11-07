# XML Schema and Sample XML File

Ensure that your XML file complies with our internal schema for a successful upload.

Format your XML file according to the schema in the sample file below:

<details>

```
<?xml version="1.0" encoding="UTF-8" ?>
<job xmlns="http://schemas.video-cdn.net/vmpro/public/v1/ingest/ftp/job.xsd" reference="abc">
    <title>FtpImportMetaData</title>
    <description>Lorem ipsum dolor sit amet, consectetur adipiscing
elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.
Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi
ut aliquip ex ea commodo consequat.</description>
    <channels>
        <id>3054</id>
    </channels>
    <keywords>
        <keyword>summer</keyword>
        <keyword>autumn</keyword>
    </keywords>
    <customMetadata>
        <field name="production company">MGM</field>
    </customMetadata>
    <source>
        <file>video001.mp4</file>
    </source>
    <actions>
        <release>
            <publish>
                <period>
                    <begin>2019-07-01T09:00:00+02:00</begin>
                    <end>2019-08-01T09:00:00+02:00</end>
                </period>
            </publish>
            <download/>
        </release>
        <delete>
            <time>2019-08-02T09:00:00+02:00</time>
        </delete>
    </actions>
    <still>
        <file>Chysathemum.jpg</file>
    </still>
    <groupId>2233</groupId>
    <securityPolicyId>950</securityPolicyId>
    <inform>
        <email>employee.name@company.com</email>
    </inform>
    <ingestActions>
        <disableAutoDelete>source</disableAutoDelete>
        <disableAutoDelete>still</disableAutoDelete>
    </ingestActions>
</job>
```

</details>


## Available property tags

The following tags are permitted within the XML file.

| Video Metadata   | Description                                                                                                                                                                  |
|------------------|------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| source           | Mandatory. If the source for your video file is not specified, then the XML file is invalid. Your upload will fail.                                                          |
| title            | By default, the system will use the original file name. (Optional)                                                                                                           |
| description      | Enter a short description for the video. (Optional)                                                                                                                          |
| keywords         | You can enter multiple keywords, if desired. (Optional)                                                                                                                      |
| reference        | To improve mapping of import files to result files,  you can specify a custom reference value. This value will be returned in the result file. (Optional)                    |
| customMetadata   | Edit custom metadata for a video. The fields are the same as the ones displayed in your video list (date uploaded, category, etc.). (Optional)                               |
| channels         | Assign your video to a channel by specifying one or more channel IDs. (Optional)                                                                                             |
|                  |
|                  | If you don't want to assign your video to a channel, you'll need to remove this tag entirely, or the upload will fail.                                                       |
| groupId          | Specify the Id of the user group this video should be assigned to. If no Id is assigned, the video will automatically be assigned to the default "Company" group. (Optional) |
| securityPolicyId | Specify the Id of the security policy that should be applied to your video. (Optional)                                                                                       |
| release          | Specify the release status of the video via the <publish> tag. (Optional)                                                                                                    |
|                  | [Times are according to D ISO 8601 , in the format YYYY-MM-DDThh:mm:ssTZD](https://www.w3.org/TR/NOTE-datetime) where: |YYYY = year
            MM = month
            T = start of the time element (required)
            hh = hour
            mm = minute
            ss = second
            TZD = timezone designator (+hh:mm or -hh:mm) |||

Example: 2019-07-01T09:00:00+02:00 would release the video at:

    09:00 Berlin time
    08:00 London time
    07:00 UTC


If a period is specified, the release is time-controlled.

```<release>
    <publish>
        <period>
            <begin>2019-07-01T09:00:00+02:00</begin>
            <end>2019-08-01T09:00:00+02:00</end>
        </period>
    </publish>
</release>
```
If an empty tag is specified <publish/>, the video is released immediately, without a time limit.
> If you entered an invalid date (for example, the release date you entered is in the past), the video will be imported without any release status.

| Video Metadata                                       | Description                                                                                                                                                                                                                                                                                                                                                                                      |
|------------------------------------------------------|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| download                                             | You can activate the download release via the <download/> element. (Optional)                                                                                                                                                                                                                                                                                                                    |
| delete                                               | Specify the date when the video has to be automatically deleted. (Optional)                                                                                                                                                                                                                                                                                                                      |
| still                                                | Specify what file should be used as a thumbnail for the video. (Optional) > The thumbnail file must not be larger than 10000 KB. You must use a thumbnail image if you define one in the XML schema. Otherwise, the upload will fail.                                                                                                                                                            | 
|inform| Specify additional people who should receive notification emails about file ingest status. The uploader will always receive notifications by default. (Optional) Notifications will be sent for the following errors: - Video file corrupted - Wrong XML schema used - Incorrect file type - The system was unable to probe video file because of an incorrect file type - Ingest system failure |
| disableAutoDelete                                    | Use this tag to prevent the system from automatically deleting video files and stills from the FTP server after processing. (Optional)  > All files will be automatically deleted after 30 days regardless of the disableAutoDelete tag.                                                                                                                                                                                                                                                       |

## XML Schema

When uploading your XML file, we check against our internal validation schema (shown below).           

<details>

```
<?xml version="1.0" encoding="UTF-8" ?>
<schema xmlns="http://www.w3.org/2001/XMLSchema"
        targetNamespace="http://schemas.video-cdn.net/vmpro/public/v1/ingest/ftp/job.xsd"
        elementFormDefault="qualified">
    <element name="job">
        <complexType>
            <all>
                <element name="source" minOccurs="1" maxOccurs="1">
                    <complexType>
                        <all minOccurs="1" maxOccurs="1">
                            <element name="file" minOccurs="1" maxOccurs="1">
                                <simpleType>
                                    <restriction base="string">
                                        <minLength value="1"/>
                                        <pattern value="[^/\\]+"/>
                                    </restriction>
                                </simpleType>
                            </element>
                        </all>
                    </complexType>
                </element>
                <element name="indexVideo" maxOccurs="1" minOccurs="0">
                    <complexType>
                        <all>
                            <element name="sourceLanguage" maxOccurs="1" minOccurs="1">
                                <simpleType>
                                    <restriction base="token">
                                        <pattern value="([a-zA-Z]{2}|[iI]-[a-zA-Z]+|[xX]-[a-zA-Z]{1,8})(-[a-zA-Z]{1,8})*"/>
                                    </restriction>
                                </simpleType>
                            </element>
                            <element name="generateSubtitle" maxOccurs="1" minOccurs="0"/>
                        </all>
                    </complexType>
                </element>
                <element name="onlineTranscoding" maxOccurs="1" minOccurs="0"/>
                <element name="title" type="string" maxOccurs="1" minOccurs="0"/>
                <element name="description" type="string" maxOccurs="1" minOccurs="0"/>
                <element name="securityPolicyId" type="int" maxOccurs="1" minOccurs="0"/>
                <element name="groupId" type="int" maxOccurs="1" minOccurs="0"/>
                <element name="keywords" maxOccurs="1" minOccurs="0">
                    <complexType>
                        <sequence minOccurs="0" maxOccurs="1">
                            <element name="keyword" type="string" minOccurs="0" maxOccurs="unbounded"/>
                        </sequence>
                    </complexType>
                </element>
                <element name="channels" minOccurs="0" maxOccurs="1">
                    <complexType>
                        <sequence minOccurs="1" maxOccurs="1">
                            <element name="id" minOccurs="1" maxOccurs="unbounded">
                                <simpleType>
                                    <restriction base="string">
                                        <minLength value="1"/>
                                        <pattern value="(([1-9])[0-9]*)"/>
                                    </restriction>
                                </simpleType>
                            </element>
                        </sequence>
                    </complexType>
                </element>
                <element name="customMetadata" minOccurs="0" maxOccurs="1">
                    <complexType>
                        <sequence minOccurs="0" maxOccurs="1">
                            <element name="field" minOccurs="0" maxOccurs="unbounded">
                                <complexType>
                                    <simpleContent>
                                        <extension base="string">
                                            <attribute name="name" type="string"/>
                                        </extension>
                                    </simpleContent>
                                </complexType>
                            </element>
                            <element name="select" minOccurs="0" maxOccurs="unbounded">
                                <complexType>
                                    <simpleContent>
                                        <extension base="string">
                                            <attribute name="name" type="string" use="required"/>
                                        </extension>
                                    </simpleContent>
                                </complexType>
                            </element>
                            <element name="multiselect" minOccurs="0" maxOccurs="unbounded">
                                <complexType>
                                    <sequence minOccurs="1" maxOccurs="unbounded">
                                        <element name="option" type="string" minOccurs="1" maxOccurs="unbounded"/>
                                    </sequence>
                                    <attribute name="name" type="string" use="required"/>
                                </complexType>
                            </element>
                        </sequence>
                    </complexType>
                </element>
                <element name="actions" minOccurs="0" maxOccurs="1">
                    <complexType>
                        <sequence minOccurs="0" maxOccurs="1">
                            <element name="release" minOccurs="1" maxOccurs="1">
                                <complexType>
                                    <sequence>
                                        <element name="publish" minOccurs="0" maxOccurs="1">
                                            <complexType>
                                                <sequence minOccurs="0" maxOccurs="1">
                                                    <element name="period" minOccurs="1" maxOccurs="1">
                                                        <complexType>
                                                            <sequence>
                                                                <element name="begin" type="dateTime" minOccurs="1"
                                                                         maxOccurs="1"/>
                                                                <element name="end" type="dateTime" minOccurs="1"
                                                                         maxOccurs="1"/>
                                                            </sequence>
                                                        </complexType>
                                                    </element>
                                                </sequence>
                                            </complexType>
                                        </element>
                                        <element name="download" minOccurs="0" maxOccurs="1" fixed=""/>
                                    </sequence>
                                </complexType>
                            </element>
                            <element name="delete" minOccurs="0" maxOccurs="1">
                                <complexType>
                                    <sequence>
                                        <element name="time" type="dateTime" minOccurs="1" maxOccurs="1"/>
                                    </sequence>
                                </complexType>
                            </element>
                        </sequence>
                    </complexType>
                </element>
                <element name="ingestActions" minOccurs="0" maxOccurs="1">
                    <complexType>
                        <sequence>
                            <element name="disableAutoDelete" minOccurs="1" maxOccurs="2">
                                <simpleType>
                                    <restriction base="string">
                                        <enumeration value="still"/>
                                        <enumeration value="video"/>
                                        <enumeration value="source"/>
                                    </restriction>
                                </simpleType>
                            </element>
                        </sequence>
                    </complexType>
                </element>
                <element name="still" minOccurs="0" maxOccurs="1">
                    <complexType>
                        <sequence>
                            <element name="file" type="string"/>
                        </sequence>
                    </complexType>
                </element>
                <element name="inform" minOccurs="0" maxOccurs="1">
                    <complexType>
                        <sequence minOccurs="1" maxOccurs="1">
                            <element name="email" type="string" minOccurs="1" maxOccurs="unbounded"/>
                        </sequence>
                    </complexType>
                </element>
            </all>
            <attribute name="reference" type="string"/>
        </complexType>
    </element>
</schema>
```
</details>

## Sample output XML file

The <video_filename.xml> file contains some important values:

| Property                                                                                                                                                 | Description                                                                                                                                     |
|----------------------------------------------------------------------------------------------------------------------------------------------------------|-------------------------------------------------------------------------------------------------------------------------------------------------|
| video id                                                                                                                                                 | The video id assigned to the uploaded video. If the video entity could not be created in VideoManager Pro, this value will not be shown.        |
| reference| 	This is the same reference as defined in the input metadata XML file. You can use this to match up input and output files in your integration. |
|jobReference|	This is an internal reference to the processing actions taken on the video file. You must include this value when contacting movingimage Professional Services for troubleshooting. |

> The <video_filename>.xml file is only a validation of the metadata. The video file itself will be further checked before transcoding; a success message within <video_filename>.xml does not guarantee that the video file itself can be transcoded.

```
<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<result fileName="myVideo.mp4" reference="MyReference" jobReference="123abc45-abcd-67ef-89ab-1234ab567890" xmlns="http://schemas.video-cdn.net/vmpro/public/v1/ingest/ftp/result.xsd">
    <success>
        <videoTitle>My Video</videoTitle>
        <video id="ABcd1234efGH5678jk90ab"/>
    </success>
</result>
```
