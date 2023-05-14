import {bodyRequester} from "../common/requestSender";

async function servicesRequest(descriptionSearchPattern) {
    descriptionSearchPattern = JSON.stringify(descriptionSearchPattern)

    return bodyRequester(
        '/list_of_services',
        'post',
        descriptionSearchPattern
    )
}

export default servicesRequest
