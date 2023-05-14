import {bodyRequester} from "../common/requestSender";

async function recordsRequest(descriptionSearchPattern) {
    descriptionSearchPattern = JSON.stringify(descriptionSearchPattern)

    return bodyRequester(
        '/home_patient',
        'post',
        descriptionSearchPattern
    )
}

export default recordsRequest
