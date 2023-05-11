import {simpleRequester} from "../common/requestSender";

async function signUpRequest(user) {
    return simpleRequester(
        '/registration',
        'post',
        user
    )
}

export default signUpRequest
