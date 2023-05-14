import {bodyRequester} from "../common/requestSender";

async function makeAppointmentRequest(appointment) {
    appointment = JSON.stringify(appointment)

    return bodyRequester(
        '/make_an_appointment',
        'post',
        appointment
    )
}

export default makeAppointmentRequest
