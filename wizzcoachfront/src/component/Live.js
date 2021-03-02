import React from 'react'
import ReactPlayer from 'react-player'
import Auth from '@aws-amplify/auth'
import {Button, Grid , Input , CardMedia} from '@material-ui/core'


const streamUrl = "https://02f97041e787.eu-west-1.playback.live-video.net/api/video/v1/eu-west-1.561462605644.channel.K5M41QB8yFd8.m3u8"

export default function Live() {
    const user = Auth.currentUserPoolUser;
    return (
        <Grid container >
        <Grid item xs={6} >
            <ReactPlayer
            url = {streamUrl}
            width ="100%"
            height = "100%"
            playing = "true"
            allow = "autoplay, encrypted-media"
            />
        </Grid>
        <Grid item  xs={4} color="primary" >
           { user && (
                <div>
                    <Input placeholder="create a comment" type="text"/>
                    <Button containedPrimary color="primary"> create comment </Button>
                </div>
            )}
        </Grid>
        </Grid>

    )
}
