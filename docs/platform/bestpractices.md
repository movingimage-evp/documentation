# Best Practices

This section provides recommendations to ensure a optimal VideoManager Pro experience.

Note that different approaches may have to be used according to individual conditions or different requirements.

## Recommended video settings

The settings below apply to videos that are converted into our standard formats after upload and streamed via Internet. 
If you want to offer your videos as individual files for download, the optimum settings may differ depending on the application area.

movingimage supports almost all video standard formats. 
To ensure good video quality for the playout of videos, we recommend the following video settings:

| Settings    | Requirements                                                                                |
|-------------|---------------------------------------------------------------------------------------------|
| Video codec | H.264, profile: "High" or at least "Extended"1920 x 1080 (1080p)                            |
| Resolution  | At least 480p If no HD is available: 1024 x 576 (PAL 16:9) respectively 768 x 576 (PAL 4:3) |
| Video bitrate            |               5.000 to 10.000 Kbit/s                                                                              |
| Audio bitrate            |      320 Kbit/s, stereo, 44,1 KHz                                                                                       |
|   Sound           |                          AAC                                                                   |

## Service domains

> If you experience problems after whitelisting the domains below, please contact Professional Services.

If your firewall blocks access to our products, you may need to whitelist the following domains and ports:

| Service                                                    | Type                                 | Host                                                                                                                                                                                          | Protocol/Port | Content Type |
|------------------------------------------------------------| ------------------------------------ | --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | ------------- | ------------ |
| **Platform**                                               |                                      |                                                                                                                                                                                               |               |              |
| Microservice authentication                                | Authentication                       | [login.movingimage.com                  ](http://login.movingimage.com/)                                                                                                                      | https:443     |              |
| **CorporateTube**                                          |                                      |                                                                                                                                                                                               |               |
| Custom subdomain                                           | Web application                      | \*.corporate.tube                                                                                                                                                                             | https:443     |              |
| Custom assets storage                                      | Assets                               | ct-assets-prod.corporate.tube                                                                                                                                                                 | https:443     |              |
| **Webcast**                                                |                                      |                                                                                                                                                                                               |               |              |
| Webcast main                                               | Web application                      | [webcast.movingimage.com](http://webcast.movingimage.com/)                                                                                                                                    | https:443     |              |
| websocket:443                                              |
| Webcast assets                                             | Assets, Images, Static files         | [mi-wbc-asset.akamaized.net](http://mi-wbc-asset.akamaized.net/)                                                                                                                              | https:443     |              |
| Webcast Live Streaming                                     | Streaming (Live, Adaptive Streaming) | [wbc-live-cdn.edge-cdn.net](http://wbc-live-cdn.edge-cdn.net/)                                                                                                                                | https:443     |              |
| Webcast Live Streaming                                     | Streaming (Live, Adaptive Streaming) | [wbc-live-1-cdn.edge-cdn.net](http://wbc-live-1-cdn.edge-cdn.net/)                                                                                                                            | https:443     |              |
| Webcast Live Entrypoint                                    | Stream Publish (Primary)             | [streaming-prod.edge-cdn.net](http://streaming-prod.edge-cdn.net/)                                                                                                                            | rtmp:1935     |              |
| Webcast Live Entrypoint                                    | Stream Publish                       | [streaming-prod-1.edge-cdn.net](http://streaming-prod-1.edge-cdn.net/)                                                                                                                        | rtmp:1935     |              |
| Video Conference Connector                                 |                                      | [vc.movingimage.com](http://vc.movingimage.com/)                                                                                                                                              | sip           |              |
|                                                            |                                      |
| [px01.vc.movingimage.com](http://px01.vc.movingimage.com/) | h323                                 |
| **VideoManager Pro**                                       |                                      |                                                                                                                                                                                               |               |
| VMPRO video management User Interface                      | Web UI                               | [vmpro.movingimage.com](http://vmpro.movingimage.com/)                                                                                                                                        | https:443     |              |
|                                                            |
| websocket:443                                              |
| Private API                                                | REST API                             | [api.video-cdn.net](http://api.video-cdn.net/)                                                                                                                                                | https:443     |              |
| Asset Upload Endpoint                                      | Asset Inbound                        | [asset-in.video-cdn.net](http://asset-in.video-cdn.net/)                                                                                                                                      | https:443     |              |
| Assets  (CDN)                                              | Asset Outbound                       | [asset-out-cdn.video-cdn.net](http://asset-out-cdn.video-cdn.net/)                                                                                                                            | https:443     |              |
| Assets (edge host)                                         | Asset Outbound                       | [ao.edge-cdn.net](http://ao.edge-cdn.net/)                                                                                                                                                    |               |
| FTP Upload                                                 | FTP                                  | [ftpingest.video-cdn.net](http://ftpingest.video-cdn.net/)                                                                                                                                    | ftp:21        |              |
|                                                            |
| ftps:990,989                                               |
| **Analytics**                                              |                                      |                                                                                                                                                                                               |               |              |
| Video analytics                                            | Analytics (Akamai based Analytics)   | [analytics.movingimage.com](http://mima.movingimage.com/)                                                                                                                                     | https:443     |              |
| Video Analytics                                            | Analytics (beta)                     | [a-fds.youborafds01.com](https://a-fds.youborafds01.com/data?outputformat=json&system=movingimage&pluginVersion=6.8.7-adapterless-js&requestNumber=0.4223595442072736&timemark=1638967649246) |               |
| Video Analytics                                            | Analytics (beta)                     | [\*.youborafds01.com](http://youborafds01.com/)                                                                                                                                               |               |
| Video Analytics                                            | Analytics (beta)                     | [\*.youborafds01.com](http://youborafds01.com/)                                                                                                                                               |               |
| **Player**                                                 |                                      |                                                                                                                                                                                               |               |              |
| Video analytics                                            | Analytics                            | [c.video-cdn.net](http://c.video-cdn.net/)                                                                                                                                                    | https:443     |              |
| (VMPro-Plays-Statistic)                                    |
| Video analytics                                            | Analytics                            | [ca.video-cdn.net](http://ca.video-cdn.net/)                                                                                                                                                  | https:443     |              |
| (View tracking for Akamai)                                 |
| Video Playout - Aka Player Configuration                   | REST API                             | [d.video-cdn.net](http://d.video-cdn.net/)                                                                                                                                                    | https:443     | text/json    |
| Video Player app Resources                                 | Player UI                            | [e.video-cdn.net](http://e.video-cdn.net/)                                                                                                                                                    | https:443     | html, js     |
| Assets                                                     | Asset Outbound                       | [asset-out-cdn.video-cdn.net](http://asset-out-cdn.video-cdn.net/)                                                                                                                            | https:443     | video/mp4    |
| Bitmovin                                                   | Licensing                            | [licensing.bitmovin.com](http://nlicensing.bitmovin.comg.bitmovin.com/)                                                                                                                       | https:443     |              |
| VOD - CDN - HLS Streaming Playback                         | VOD streams CDN                      | [vod.video-cdn.net](http://vod.video-cdn.net/)                                                                                                                                                | https:443     |              |
| **REST API**                                               |                                      |                                                                                                                                                                                               |               |              |
|                                                            |                                      | [api.video-cdn.net](http://api.video-cdn.net/)                                                                                                                                                |               |
