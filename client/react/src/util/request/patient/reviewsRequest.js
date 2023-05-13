import {bodyRequester} from "../common/requestSender";

async function reviewsRequest(props) {
    return bodyRequester(
        '/review',
        'get'
    )
}

export default reviewsRequest;
