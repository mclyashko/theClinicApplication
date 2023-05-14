import {simpleRequester} from "../common/requestSender";

async function cancelEntryRequest(deleteRecordInfo) {
    deleteRecordInfo = JSON.stringify(deleteRecordInfo)

    return simpleRequester(
        '/cancel_entry',
        'post',
        deleteRecordInfo
    )
}

export default cancelEntryRequest
