import {bodyRequester} from "../common/requestSender";

async function sendQuizRequest(questions) {
    questions = JSON.stringify(questions)

    return bodyRequester(
        '/quiz/results',
        'post',
        questions
    )
}

export default sendQuizRequest
