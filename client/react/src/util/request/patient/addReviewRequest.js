import {simpleRequester} from "../common/requestSender";

async function addReviewRequest(review) {
    review = JSON.stringify(review)

    return simpleRequester(
        '/review',
        'post',
        review
    )
}

export default addReviewRequest
