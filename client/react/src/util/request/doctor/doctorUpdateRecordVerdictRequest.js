import {simpleRequester} from "../common/requestSender";

async function doctorUpdateRecordVerdictRequest(recordVerdictData) {
    recordVerdictData = JSON.stringify(recordVerdictData)

    return simpleRequester(
        '/record_data',
        'post',
        recordVerdictData
    )
}

export default doctorUpdateRecordVerdictRequest
