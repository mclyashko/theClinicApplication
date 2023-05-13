import {bodyRequester} from "../common/requestSender";

async function doctorFilterRecordsRequest(searchData) {
    if (searchData.email === '') {
        searchData.email = null
    }

    searchData = JSON.stringify(searchData)

    return bodyRequester(
        '/filterByEmail',
        'post',
        searchData
    )
}

export default doctorFilterRecordsRequest
