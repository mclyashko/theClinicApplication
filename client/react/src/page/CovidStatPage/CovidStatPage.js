import React, {useEffect, useState} from 'react';
import PatientNavbar from "../../component/PatientNavbar/PatientNavbar";
import Wrapper from "../../component/Wrapper/Wrapper";
import covidApiRequest from "../../util/request/patient/covidApiRequest";

function CovidStatPage(props) {
    const [covidInfo, setCovidInfo] = useState({
        country: '',
        day: '',
        population: '',
        cases: {
            new: '',
            active: '',
            critical: '',
            recovered: ''
        },
        deaths: {
            new: '',
            total: ''
        },
        tests: {
            total: ''
        }
    })

    useEffect(() => {
        covidApiRequest().then(covidInfoResponse =>
            setCovidInfo(covidInfoResponse.response[0])
        )
    }, [])

    return (
        <div>
            <PatientNavbar/>
            <Wrapper>
                <h1 className="bg-danger text-light" style={{ borderRadius: '15%', textAlign: 'center' }}>
                    Актуальная статитсика по проблеме коронавирусной инфекции
                </h1>
                <div style={{ margin: '15px' }}>
                    <table className="container table-bright table-bordered" style={{ marginLeft: 'auto', marginRight: 'auto', width: '75%', fontSize: 'xx-large' }}>
                        <tbody>
                            <tr>
                                <td>Статистика по стране:</td>
                                <td>{covidInfo.country}</td>
                            </tr>
                            <tr>
                                <td>Актуальность данных:</td>
                                <td>{covidInfo.day}</td>
                            </tr>
                            <tr>
                                <td>Численность населения:</td>
                                <td>{covidInfo.population}</td>
                            </tr>
                            <tr>
                                <td>Информация о заболевших:</td>
                                <td></td>
                            </tr>
                            <tr>
                                <td>Новые случаи:</td>
                                <td>{covidInfo.cases.new}</td>
                            </tr>
                            <tr>
                                <td>Болеющие:</td>
                                <td>{covidInfo.cases.active}</td>
                            </tr>
                            <tr>
                                <td>В критическом состоянии:</td>
                                <td>{covidInfo.cases.critical}</td>
                            </tr>
                            <tr>
                                <td>Выздоровевшие:</td>
                                <td>{covidInfo.cases.recovered}</td>
                            </tr>
                            <tr>
                                <td>Информация об умерших:</td>
                                <td></td>
                            </tr>
                            <tr>
                                <td>Новые случаи:</td>
                                <td>{covidInfo.deaths.new}</td>
                            </tr>
                            <tr>
                                <td>Общее число умерших:</td>
                                <td>{covidInfo.deaths.total}</td>
                            </tr>
                            <tr>
                                <td>Тестирование населения:</td>
                                <td></td>
                            </tr>
                            <tr>
                                <td>Общее число проведенных тестов:</td>
                                <td>{covidInfo.tests.total}</td>
                            </tr>
                        </tbody>
                    </table>
                </div>
            </Wrapper>
        </div>
    );
}

export default CovidStatPage;
