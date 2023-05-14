import React, {useEffect, useState} from 'react';
import PatientNavbar from "../../component/PatientNavbar/PatientNavbar";
import Wrapper from "../../component/Wrapper/Wrapper";
import {useSelector} from "react-redux";
import servicesRequest from "../../util/request/patient/servicesRequest";
import makeAppointmentRequest from "../../util/request/patient/makeAppointmentRequest";
import {useNavigate} from "react-router-dom";
import {CORRECT_TIME_ROUTE, WRONG_TIME_ROUTE} from "../../util/consts";

function ListOfServicesPage(props) {
    const userId = useSelector(state => state.userInf.id)
    const name = useSelector(state => state.userInf.name)
    const [services, setServices] = useState([])
    const [descriptionSearchPattern, setDescriptionSearchPattern] = useState('')
    const navigate = useNavigate();

    useEffect(() => {
        servicesRequest().then(servicesList => {
            setServices(servicesList)
        })
    }, [])

    return (
        <div>
            <PatientNavbar/>
            <Wrapper>
                <div>
                    <h1>Добрый день, {name}</h1>
                </div>
                <div style={{ padding: '15px' }}>
                    <form>
                        <input value={descriptionSearchPattern}
                               onChange={event => {
                                   setDescriptionSearchPattern(event.target.value)
                               }}
                            style={{ margin: '5px', width: '15%' }} type="text" id="procedureDescription" name="procedureDescription" className="form-control" placeholder="Описание"/>
                    </form>
                    <button onClick={ async () => {
                        await servicesRequest({procedureDescription: descriptionSearchPattern})
                            .then(servicesList => {
                                setServices(servicesList)
                            })
                    }}
                            style={{ margin: '5px' }} type="submit">Осуществить поиск по описанию процедуры
                    </button>
                </div>
                <div>
                    <h2>Предоставляемые услуги:</h2>
                </div>
                <table className="container table-bright table-bordered">
                    {services.length === 0 ? <tbody><tr><td colSpan="2">Нет доступных услуг</td></tr></tbody> :
                        <>
                            <thead>
                                <tr>
                                    <th>Описание</th>
                                    <th>Стоимость</th>
                                    <th>Принимающий врач</th>
                                    <th>Запись</th>
                                </tr>
                            </thead>
                            <tbody>
                            {
                                services.map(service => {
                                    return (
                                        <tr key={service.id}>
                                            <td className="col">
                                                <div style={{ display: 'flex', flexDirection: 'column' }}>
                                                    <span>{service.description}</span>
                                                </div>
                                            </td>
                                            <td className="col">
                                                <div style={{ display: 'flex', flexDirection: 'column' }}>
                                                    <span>{service.cost} Руб.</span>
                                                </div>
                                            </td>
                                            <td className="col">
                                                <div style={{ display: 'flex', flexDirection: 'column' }}>
                                                    <span>Фамилия: {service.artistInfo.artist.name}</span>
                                                    <span>Имя: {service.artistInfo.artist.surname}</span>
                                                    <span>Отчество: {service.artistInfo.artist.patronymic}</span>
                                                    <span>Кабинет: {service.artistInfo.cabinet}</span>
                                                </div>
                                            </td>
                                            <td className="col">
                                                <div style={{ display: 'flex', flexDirection: 'column', margin: '5px', padding: '5px' }}>
                                                    <span>Запись на процедуру с ID {service.id}</span>
                                                    <form>
                                                        <input type="hidden" value={userId} name="clientId"/>
                                                        <input type="hidden" value={service.id} name="procedureId"/>
                                                        <input value={service.dateTime || '2023-01-01T00:00'}
                                                               onChange={event => {
                                                                   let servicesCopy = [...services]
                                                                   servicesCopy[service.id - 1].dateTime = event.target.value
                                                                   setServices(servicesCopy)
                                                               }}
                                                            type="datetime-local" id="dateTime" name="dateTime" className="form-control" placeholder="2023-01-01T00:00" min="2022-01-01T00:00" max="2030-01-01T00:00"
                                                            required="required"/>
                                                    </form>
                                                    <button onClick={ async () => {
                                                        let result = await makeAppointmentRequest({clientId: userId, procedureId: service.id, dateTime: service.dateTime})

                                                        if (result.status) {
                                                            navigate(CORRECT_TIME_ROUTE)
                                                        } else {
                                                            navigate(WRONG_TIME_ROUTE)
                                                        }
                                                    }}
                                                        type="submit" className="btn btn-secondary btn-block" style={{ marginTop: '15px', width: '100%' }}>
                                                        Записаться
                                                    </button>
                                                </div>
                                            </td>
                                        </tr>
                                    )
                                })
                            }
                            </tbody>
                        </>
                    }
                </table>
            </Wrapper>
        </div>
    );
}

export default ListOfServicesPage;
