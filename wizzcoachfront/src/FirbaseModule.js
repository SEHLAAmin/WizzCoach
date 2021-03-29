export const doLogin = async ( username , database , handleUpdate) => {
 await database.ref('/notifs/'+ username).remove()
}

export const doOffer = async ( to , offer , database , username) => {

}

export const doAnswer = async ( to , answer , database , username) => {

}


export const doCandidate = async ( to , candidate , database , username) => {

}