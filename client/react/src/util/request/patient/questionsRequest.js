import {bodyRequester} from "../common/requestSender";

async function questionsRequest() {
    return bodyRequester(
        '/quiz',
        'get'
    )
}

export default questionsRequest
