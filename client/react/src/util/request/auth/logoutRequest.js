import {simpleRequester} from "../common/requestSender";

async function logoutRequest() {
    return simpleRequester(
        '/logout',
        'get'
    )
}

export default logoutRequest
