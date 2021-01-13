import React, { Component } from 'react'

import Webcam from "react-webcam";


const WebcamComponent = () => <Webcam />;
export default class Cam extends Component {



    render() {
        return (
            <div>
             <WebcamComponent/>
             </div>
        )
    }
}
