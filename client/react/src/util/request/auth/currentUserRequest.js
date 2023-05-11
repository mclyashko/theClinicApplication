import {bodyRequester} from "../common/requestSender";

async function currentUserRequest(props) {
    return bodyRequester(
        '/get_current_user',
        'get',
    )
}

export default currentUserRequest;
