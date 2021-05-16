import React from 'react'
import '@firebase/database'

const handleUpdtate = (notif , username ) => {
if (notif) {
    switch(notif.type){
        case 'offer' : 
        //listen to the connection events

        //send a answer
        break; 
        case 'answer' : 
        //start the call
        break;
        case 'candidate' : 
        //add candidate to our connection
        break;
        default:
            break;
    }
}
}

export default function VideoChatContainer() {
    return (
        <div>
           hahhahahaha 
        </div>
    )
}
