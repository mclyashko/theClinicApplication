import {bodyRequester} from "../common/requestSender";

async function signInRequest(login, password) {
    let urlencoded = new URLSearchParams();
    urlencoded.append("username", login);
    urlencoded.append("password", password);

    return bodyRequester(
        '/login',
        'post',
        urlencoded,
        'application/x-www-form-urlencoded'
    )
}

export default signInRequest
