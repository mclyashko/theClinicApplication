import {bodyRequester} from "../common/requestSender";

async function covidApiRequest() {
    return bodyRequester(
        '/covid_stat',
        'get'
    )
}

export default covidApiRequest
