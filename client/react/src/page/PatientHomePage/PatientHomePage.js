import React, {useEffect, useState} from 'react';
import PatientNavbar from "../../component/PatientNavbar/PatientNavbar";
import Wrapper from "../../component/Wrapper/Wrapper";
import {useSelector} from "react-redux";
import recordsRequest from "../../util/request/patient/recordsRequest";
import cancelEntryRequest from "../../util/request/patient/cancelEntryRequest";

function PatientHomePage(props) {
    const userId = useSelector(state => state.userInf.id)
    const name = useSelector(state => state.userInf.name)
    const [records, setRecords] = useState([])
    const [descriptionSearchPattern, setDescriptionSearchPattern] = useState('')

    useEffect(() => {
        recordsRequest().then(recordsList => {
            setRecords(recordsList)
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
                               onChange={ event => {
                                   setDescriptionSearchPattern(event.target.value)
                               }}
                            style={{ margin: '5px', width: '15%' }} type="text" id="procedureDescription" name="procedureDescription" className="form-control" placeholder="Описание"/>
                    </form>
                    <button onClick={ async () => {
                        recordsRequest({description: descriptionSearchPattern}).then(recordsList => {
                            setRecords(recordsList)
                        })
                    }}
                        style={{ margin: '5px' }} type="submit">Осуществить поиск по описанию процедуры</button>
                </div>
                <div>
                    <h2>Список записей:</h2>
                </div>
                <table className="container table-bright table-bordered">
                    {records.length === 0 ? <tbody><tr><td colSpan="2"> Нет записей</td></tr></tbody> :
                        <>
                            <thead>
                                <tr>
                                    <th>ID и время записи</th>
                                    <th>Пол и дата рождения пациента</th>
                                    <th>ФИО пациента</th>
                                    <th>Контактные данные пациента</th>
                                    <th>Информация о записи</th>
                                    <th>Принимающий врач</th>
                                    <th>Вердикт</th>
                                    <th>Отменить запись</th>
                                </tr>
                            </thead>
                            <tbody>
                            {
                                records.map((record) => {
                                    return (
                                        <tr key={record.id}>
                                            <td className="col">
                                                <div style={{ display: 'flex', flexDirection: 'column' }}>
                                                    <span>ID: {record.id}</span>
                                                    <span>Время записи: {record.dateTime}</span>
                                                </div>
                                            </td>
                                            <td className="col">
                                                <div style={{ display: 'flex', flexDirection: 'column' }}>
                                                    <span>Пол: {record.client.gender}</span>
                                                    <span>Дата рождения: {record.client.dateOfBirth}</span>
                                                </div>
                                            </td>
                                            <td className="col">
                                                <div style={{ display: 'flex', flexDirection: 'column' }}>
                                                    <span>Фамилия: {record.client.surname}</span>
                                                    <span>Имя: {record.client.name}</span>
                                                    <span>Отчество: {record.client.patronymic}</span>
                                                </div>
                                            </td>
                                            <td className="col">
                                                <div style={{ display: 'flex', flexDirection: 'column' }}>
                                                    <span>Телефон: {record.client.phoneNumber}</span>
                                                    <span>E-mail: {record.client.email}</span>
                                                </div>
                                            </td>
                                            <td className="col">
                                                <div style={{ display: 'flex', flexDirection: 'column' }}>
                                                    <span>Услуга: {record.procedure.description}</span>
                                                    <span>Стоимость: {record.procedure.cost}</span>
                                                </div>
                                            </td>
                                            <td className="col">
                                                <div style={{ display: 'flex', flexDirection: 'column' }}>
                                                    <span>Фамилия: {record.procedure.artistInfo.artist.name}</span>
                                                    <span>Имя: {record.procedure.artistInfo.artist.surname}</span>
                                                    <span>Отчество: {record.procedure.artistInfo.artist.patronymic}</span>
                                                    <span>Кабинет: {record.procedure.artistInfo.cabinet}</span>
                                                </div>
                                            </td>
                                            <td className="col">
                                                <div style={{ display: 'flex', flexDirection: 'column' }}>
                                                    <span>Вердикт: {record.verdict}</span>
                                                </div>
                                            </td>
                                            <td className="col">
                                                {record.verdict === 'None' &&
                                                    <div style={{ display: 'flex', flexDirection: 'column', margin: '5px', padding: '5px' }}>
                                                        <span>Отмена записи с ID {record.id}</span>
                                                        <form>
                                                            <input type="hidden" value={record.id} name="id"/>
                                                        </form>
                                                        <button onClick={ async () => {
                                                            await cancelEntryRequest({id: record.id})

                                                            recordsRequest().then(recordsList => {
                                                                setRecords(recordsList)
                                                            })
                                                        }}
                                                            type="submit" className="btn btn-secondary btn-block" style={{ width: '100%' }}>
                                                            Отменить
                                                        </button>
                                                    </div>
                                                }
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
    )
}

export default PatientHomePage;
