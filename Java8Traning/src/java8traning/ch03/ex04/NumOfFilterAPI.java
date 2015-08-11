/*
 * Copyright (c) 2015. Isao Aruga. All rights reserved.
 */

package java8traning.ch03.ex04;

/**
 * Created by akari on 2015/08/10.
 * Filterという名前を持つ関数型インタフェースがJava APIにはいくつありますか。
 * そのうちどれが、Predicateよりも付加価値がありますか。
 * ### Filterの名を持つインターフェース
 * DirectoryStream.Filter<T> boolean	accept(T entry)
 * EventFilter boolean	accept(XMLEvent event)
 * FileFilter boolean	accept(File pathname)
 * FilenameFilter boolean	accept(File dir, String name)
 * Filter boolean	isLoggable(LogRecord record)
 * LSSerializerFilter int	getWhatToShow()
 * NotificationFilter boolean	isNotificationEnabled(Notification notification)
 * ServiceRegistry.Filter boolean	filter(Object provider)
 * StreamFilter boolean	accept(XMLStreamReader reader)
 * <p>
 * ### これらのうちPredicateよりも付加価値があるもの
 * LSSerializerFilter は、戻り値が違うので論外。
 * FilenameFilter は、BiPredicateと比較するべき？
 * DirectoryStream.FilterはIOExceptionを投げる。
 */
public class NumOfFilterAPI {
}
